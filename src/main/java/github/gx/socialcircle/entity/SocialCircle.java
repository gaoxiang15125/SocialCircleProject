package github.gx.socialcircle.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @program: socialcircle
 * @description: 圈子定义信息实体类
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2021-03-14 11:16
 **/
@Data
public class SocialCircle {

    @TableId
    private long id;

    /**
     * 圈子名称
     */
    private String circleName;

    /**
     * 圈子介绍
     */
    private String circleDescription;

    /**
     * 经度值
     */
    private long longitude;

    /**
     * 纬度值
     */
    private long latitude;


}
