package mg.uha.miage.metier.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import mg.uha.miage.dao.interf.ArticleDAOInterf;
import mg.uha.miage.entities.Article;
import mg.uha.miage.metier.interf.ArticleMetierInterf;

@Transactional
public class ArticleMetierImpl implements ArticleMetierInterf {

	private ArticleDAOInterf articleDAO;

	public void setArticleDAO(ArticleDAOInterf articleDAO) {
		this.articleDAO = articleDAO;
	}

	@Override
	public Integer ajoutArticle(Article c) {
		// TODO Auto-generated method stub
		return articleDAO.ajoutArticle(c);
	}

	@Override
	public void updateArticle(Article c) {
		// TODO Auto-generated method stub
		articleDAO.updateArticle(c);
	}

	@Override
	public void deleteArticle(Integer idC) {
		// TODO Auto-generated method stub
		articleDAO.deleteArticle(idC);
	}

	@Override
	public List<Article> listArticle() {
		// TODO Auto-generated method stub
		return articleDAO.listArticle();
	}

	@Override
	public Article getArticle(Integer idC) {
		// TODO Auto-generated method stub
		return articleDAO.getArticle(idC);
	}

}
