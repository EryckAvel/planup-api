package com.eryckavel.planup.service;

import com.eryckavel.planup.dto.response.query.MontanteHistoricoResponseQueryDTO;
import com.eryckavel.planup.repository.MontanteHistoricoRepository;
import com.eryckavel.planup.repository.UsuarioRepository;
import com.eryckavel.planup.util.JwtUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MontanteHistoricoService extends BaseService{

    private final MontanteHistoricoRepository montanteHistoricoRepository;

    public MontanteHistoricoService(JwtUtil jwtUtil, UsuarioRepository usuarioRepository, MontanteHistoricoRepository montanteHistoricoRepository) {
        super(jwtUtil, usuarioRepository);
        this.montanteHistoricoRepository = montanteHistoricoRepository;
    }

    public List<MontanteHistoricoResponseQueryDTO> listarMontanteHistorico(){
        return montanteHistoricoRepository.listarMontanteHistorico(getUsuarioLogado().getId());
    }


}
