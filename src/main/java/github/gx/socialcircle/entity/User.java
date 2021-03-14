package github.gx.socialcircle.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @program: socialcircle
 * @description: 用户信息实体类
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2021-03-14 10:59
 **/
@Data
public class User {

    @TableId
    private long id;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 用户绑定的邮箱
     */
    private String email;

    /**
     * 个人签名
     */
    private String description;

    /**
     * 性别,读入系统后转化为 枚举类型
     */
    private int sex;
}
