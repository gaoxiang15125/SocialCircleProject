package github.gx.socialcircle.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @program: socialcircle
 * @description: 圈子模块相关信息存储表
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2021-03-14 11:42
 **/
@Data
public class CircleModule {

    @TableId
    private long id;

    private long circleId;

    /**
     * 板块名称
     */
    private String moduleName;

    /**
     * 板块描述
     */
    private String moduleDescription;
}
