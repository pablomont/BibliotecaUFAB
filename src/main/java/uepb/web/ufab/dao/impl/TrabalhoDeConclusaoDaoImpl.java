package uepb.web.ufab.dao.impl;


import javax.transaction.Transactional;


import org.springframework.context.annotation.Configuration;

import org.springframework.stereotype.Repository;


import uepb.web.ufab.dao.inter.ITrabalhoDeConclusaoDao;

import uepb.web.ufab.model.itemAcervo.TrabalhoDeConclusao;


@Configuration
@Transactional
@Repository
	/**
	* <h1>RevistaDao</h1>
	* TrabalhoDeConclusaoDao é um dos itens do acervo
	*
	* @author  Samuel Rufino e Pablo Monteiro
	* @version 1.0
	* @since   2018-04-20
	*/
public class TrabalhoDeConclusaoDaoImpl extends GenericDaoImpl<TrabalhoDeConclusao> implements ITrabalhoDeConclusaoDao {

	public void updateTrabalhoDeConclusao(TrabalhoDeConclusao trabalhoDeConclusao) {
		TrabalhoDeConclusao item =  getItemById(trabalhoDeConclusao.getId());
		
		item.setAutores(trabalhoDeConclusao.getAutores());
		item.setNomeItem(trabalhoDeConclusao.getNomeItem());
		item.setDate(trabalhoDeConclusao.getDate());
		item.setLocal(trabalhoDeConclusao.getLocal());
		item.setOrientadores(trabalhoDeConclusao.getOrientadores());
		item.setTipo(trabalhoDeConclusao.getTipo());
		super.updateItem(item);
		
	}

}