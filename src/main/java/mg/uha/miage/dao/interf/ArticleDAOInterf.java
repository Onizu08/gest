package mg.uha.miage.dao.interf;

import java.util.List;

import mg.uha.miage.entities.Article;

public interface ArticleDAOInterf {

	public Integer ajoutArticle(Article c);

	public void updateArticle(Article c);

	public void deleteArticle(Integer idC);

	public List<Article> listArticle();

	public Article getArticle(Integer idC);
}
