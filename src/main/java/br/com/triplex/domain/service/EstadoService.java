package br.com.triplex.domain.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.triplex.domain.exception.EntidadeEmUsoException;
import br.com.triplex.domain.exception.EntidadeNaoEncontradaException;
import br.com.triplex.domain.model.Estado;
import br.com.triplex.domain.model.Pais;
import br.com.triplex.domain.repository.IEstadoRepository;
import br.com.triplex.domain.repository.IPaisRepository;

@Service
public class EstadoService {
	@Autowired
	private IEstadoRepository estadoRepository;
	
	@Autowired
	private IPaisRepository paisRepository;
	
	public Estado salvar(Estado estado) {
		
		//faz uma buca no objeto pais
		Long paisId = estado.getPais().getId();
		Pais pais = paisRepository.findById(paisId)
					.orElseThrow(()-> new EntidadeNaoEncontradaException(
					String.format("Não existe cadastro de pais com código %d", paisId)));
		estado.setPais(pais);
		return estadoRepository.save(estado);
	}
	
	public void excluir(Long id) {
		try {
			estadoRepository.deleteById(id);
			}catch (EmptyResultDataAccessException e) {
				throw new EntidadeNaoEncontradaException(
						String.format("Não existe cadastro de estado com o códogo %d", id));
			}		
			catch (DataIntegrityViolationException e) {
				throw new EntidadeEmUsoException(String.format("Estado de código %d não pode ser removida, pois esta em uso", id));
			}
	}
	
	public Estado buscarOuFalhar(Long id) {
		return estadoRepository.findById(id)
				.orElseThrow(()-> new EntidadeNaoEncontradaException("Não existe cadastro de estado com o códogo %d"));
	}

}
