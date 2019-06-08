package com.likzn.lisblog.service;

import com.likzn.lisblog.dto.ArticleDTO;
import com.likzn.lisblog.entity.ArticleCategory;
import com.likzn.lisblog.entity.ArticleInfo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @auther: Li jx
 * @date: 2019/6/3 19:05
 * @description:
 */
@Service
public class ArticleInfoService extends BaseService {


    @Transactional
    public void addArticle(ArticleDTO articleDTO) {
        ArticleInfo articleInfo = new ArticleInfo();
        articleInfo.setId(articleDTO.getId());
        articleInfo.setCategoryId(articleDTO.getCategoryId());
        articleInfo.setContent(articleDTO.getContent());
        articleInfo.setIsTop(articleDTO.getIsTop());
        articleInfo.setSummary(articleDTO.getSummary());
        articleInfo.setTitle(articleDTO.getTitle());
        articleInfoRepository.save(articleInfo);

        ArticleCategory articleCategory = articleCategoryRepository.findById(articleDTO.getCategoryId()).get();
        articleCategory.setNumber(articleCategory.getNumber() + 1);
        articleCategoryRepository.save(articleCategory);

    }


    public ArticleInfo selectArticleById(Long id) {
        ArticleInfo articleInfo = articleInfoRepository.findById(id).get();
        articleInfo.setTraffic(articleInfo.getTraffic() + 1);
        articleInfoRepository.save(articleInfo);

        return articleInfo;
    }

    public void updateArticle(ArticleInfo articleInfo) {
        ArticleInfo articleInfo1 = articleInfoRepository.findById(articleInfo.getId()).get();
        if (!articleInfo.getCategoryId().equals(articleInfo1.getCategoryId())) {
            Long oldCategoryId = articleInfo1.getCategoryId();
            if (articleCategoryRepository.findById(oldCategoryId).isPresent()) {
                articleCategoryRepository.reduceNumber(oldCategoryId);

            }
            articleCategoryRepository.addNumber(articleInfo.getCategoryId());
        }
        articleInfo.setTraffic(articleInfo1.getTraffic());
        articleInfo.setCreateTime(articleInfo1.getCreateTime());
        articleInfo.setUpdateTime(articleInfo1.getUpdateTime());

        articleInfoRepository.save(articleInfo);
    }

}
