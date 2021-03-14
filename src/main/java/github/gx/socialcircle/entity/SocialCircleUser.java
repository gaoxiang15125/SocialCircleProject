package github.gx.socialcircle.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @program: socialcircle
 * @description: 圈子相关成员信息存储表
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2021-03-14 11:29
 **/
@Data
public class SocialCircleUser {

    @TableId
    private long id;

    private long socialCircleId;

    private long userId;

    private int memberType;
}
