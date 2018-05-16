package mg.uha.miage.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import mg.uha.miage.dao.interf.ArticleDAOInterf;
import mg.uha.miage.entities.Article;

@Transactional
public class ArticleDAOImpl implements ArticleDAOInterf {

	@PersistenceContext
	private EntityManager el;

	@Override
	public Integer ajoutArticle(Article c) {
		// TODO Auto-generated method stub
		el.persist(c);
		return c.getArticleId();
	}

	@Override
	public void updateArticle(Article c) {
		// TODO Auto-generated method stub
		el.merge(c);
	}

	@Override
	public void deleteArticle(Integer idC) {
		// TODO Auto-generated method stub
		Article a = getArticle(idC);
		el.remove(a);
	}

	@Override
	public List<Article> listArticle() {
		// TODO Auto-generated method stub
		Query req = el.createQuery("select a from Article a");
		return req.getResultList();
	}

	@Override
	public Article getArticle(Integer idC) {
		// TODO Auto-generated method stub
		return el.find(Article.class, idC);
	}

}
