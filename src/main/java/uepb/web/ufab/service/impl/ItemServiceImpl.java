package uepb.web.ufab.service.impl;


import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import uepb.web.ufab.model.itemAcervo.ItemAcervo;
import uepb.web.ufab.service.inter.IItemAcervoService;


@Transactional
@Service

/**
* <h1>CursoServiceImpl</h1>
* CursoServiceImpl Implementa todos os serviços dos itens de acervo
*
* @author  Samuel Rufino e Pablo Monteiro
* @version 1.0
* @since   2018-04-20
*/
public class ItemServiceImpl extends GenericServiceImpl<ItemAcervo> implements IItemAcervoService{

}
