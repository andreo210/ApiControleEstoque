package br.com.triplex.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.triplex.domain.exception.EntidadeEmUsoException;
import br.com.triplex.domain.exception.EntidadeNaoEncontradaException;
import br.com.triplex.domain.model.Estado;
import br.com.triplex.domain.repository.IEstadoRepository;

@Service
public class EstadoService {
	@Autowired
	private IEstadoRepository estadoRepository;
	
	public Estado salvar(Estado estado) {
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
