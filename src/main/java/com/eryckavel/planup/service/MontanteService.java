package com.eryckavel.planup.service;

import com.eryckavel.planup.dto.request.custom.CadastrarMontanteRequestDTO;
import com.eryckavel.planup.dto.response.query.RelacaoMontanteResponseQueryDTO;
import com.eryckavel.planup.model.Montante;
import com.eryckavel.planup.model.MontanteHistorico;
import com.eryckavel.planup.model.Usuario;
import com.eryckavel.planup.model.enums.TipoMovimentoHistorico;
import com.eryckavel.planup.repository.MontanteHistoricoRepository;
import com.eryckavel.planup.repository.MontanteRepository;
import com.eryckavel.planup.repository.UsuarioRepository;
import com.eryckavel.planup.util.JwtUtil;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MontanteService extends BaseService{

    private final MontanteRepository montanteRepository;
    private final MontanteHistoricoRepository montanteHistoricoRepository;

    public MontanteService(JwtUtil jwtUtil, UsuarioRepository usuarioRepository, MontanteRepository montanteRepository, MontanteHistoricoRepository montanteHistoricoRepository) {
        super(jwtUtil, usuarioRepository);
        this.montanteRepository = montanteRepository;
        this.montanteHistoricoRepository = montanteHistoricoRepository;
    }

    public RelacaoMontanteResponseQueryDTO consultarRelacaoMontate(){
        return montanteRepository.consultarRelacaoMontante(getUsuarioLogado().getId());
    }

    public String cadastrarMontante(CadastrarMontanteRequestDTO dto){
        Optional<Montante> montanteExiste = montanteRepository.buscarPorUsuario(getUsuarioLogado().getId());
        Montante montante;
        if (montanteExiste.isEmpty()) {
            montante = new Montante();
            criarMontante(montante, getUsuarioLogado());
            montante = montanteRepository.save(montante);
        } else {
            montante = montanteExiste.get();
        }
        if (montante.getSaldo().equals(0.0) && dto.getTipoMovimento().equals(TipoMovimentoHistorico.SAIDA))
            throw new RuntimeException("Não e possivel fazer retirada de Saldo Zerado!");
        if (montante.getSaldo() < dto.getValor() && dto.getTipoMovimento().equals(TipoMovimentoHistorico.SAIDA))
            throw new RuntimeException("Não e possivel fazer a retirada a mais do que tem no saldo!");
        MontanteHistorico historico = new MontanteHistorico();
        criarMontanteHistorico(historico, dto, montante);
        montanteHistoricoRepository.save(historico);
        montante.setSaldo(historico.getValorAtual());
        montanteRepository.save(montante);
        return "Montante Salvo!";
    }

    private void criarMontante(Montante novoMontante, Usuario usuario) {
        novoMontante.setUsuario(usuario);
        novoMontante.setSaldo(0.0);
    }

    private void criarMontanteHistorico(MontanteHistorico historico, CadastrarMontanteRequestDTO dto, Montante montante) {
        historico.setMontante(montante);
        historico.setTipoMovimento(dto.getTipoMovimento());
        historico.setValorAnterior(montante.getSaldo());
        historico.setValorDiferenca(dto.getValor());
        double valorAtual;
        if (dto.getTipoMovimento().equals(TipoMovimentoHistorico.ENTRADA)) {
            valorAtual = dto.getValor() + montante.getSaldo();
        } else {
            valorAtual = montante.getSaldo() - dto.getValor();
        }
        historico.setValorAtual(valorAtual);
    }

}
