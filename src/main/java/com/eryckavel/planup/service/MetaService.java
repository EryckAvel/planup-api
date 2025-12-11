package com.eryckavel.planup.service;

import com.eryckavel.planup.dto.request.custom.CadastrarMetaRequestDTO;
import com.eryckavel.planup.dto.request.custom.AtualizarMetaRequestDTO;
import com.eryckavel.planup.dto.response.model.MetaResponseDTO;
import com.eryckavel.planup.model.Meta;
import com.eryckavel.planup.model.Usuario;
import com.eryckavel.planup.repository.MetaRepositoy;
import com.eryckavel.planup.repository.UsuarioRepository;
import com.eryckavel.planup.util.JwtUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetaService extends BaseService {

    private final MetaRepositoy metaRepositoy;

    public MetaService(JwtUtil jwtUtil, UsuarioRepository usuarioRepository, MetaRepositoy metaRepositoy) {
        super(jwtUtil, usuarioRepository);
        this.metaRepositoy = metaRepositoy;
    }

    public List<MetaResponseDTO> listar(){
        List<Meta> metas = metaRepositoy.listar(getUsuarioLogado().getId());
        return metas.stream().map(MetaResponseDTO::new).toList();
    }

    public String cadastrarMeta(CadastrarMetaRequestDTO dto){
        Meta meta = new Meta();
        criarMeta(meta, dto, getUsuarioLogado());
        metaRepositoy.save(meta);
        return "Meta Cadastrada!";
    }

    public String atualizar(Long idMeta, AtualizarMetaRequestDTO dto) {
        Meta meta = metaRepositoy.findById(idMeta)
                .orElseThrow(() -> new EntityNotFoundException("Meta não encontrada!"));
        atualizarMeta(meta, dto);
        metaRepositoy.save(meta);
        return "Meta atualizada com sucesso!";
    }

    private void criarMeta(Meta meta, CadastrarMetaRequestDTO dto, Usuario usuario) {
        meta.setUsuario(usuario);
        meta.setNomeMeta(dto.getNomeMeta());
        meta.setValorEstimado(dto.getValorEstimado());
    }

    private void atualizarMeta(Meta meta, AtualizarMetaRequestDTO dto){
        if (dto.getNomeMeta() != null) meta.setNomeMeta(dto.getNomeMeta());
        if (dto.getValorEstimado() != null) meta.setValorEstimado(dto.getValorEstimado());
        if (dto.getValorGasto() != null) meta.setValorGasto(dto.getValorGasto());
    }

}

