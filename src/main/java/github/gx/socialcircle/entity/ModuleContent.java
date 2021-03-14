package github.gx.socialcircle.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @program: socialcircle
 * @description: 板块子项内容
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2021-03-14 11:53
 **/
@Data
public class ModuleContent {

    @TableId
    private long id;

    /**
     * 模块子项描述信息
     */
    private String description;

    /**
     * 点赞数
     */
    private int thumbUpNum;

    /**
     * 评论数，子项内容暂不考虑
     */
    private int talkNum;

    /**
     * 收藏数
     */
    private int collectionNum;

}
