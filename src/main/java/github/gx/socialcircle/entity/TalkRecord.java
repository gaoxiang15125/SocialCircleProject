package github.gx.socialcircle.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @program: socialcircle
 * @description: 聊天记录相关信息
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2021-03-14 12:04
 **/
@Data
public class TalkRecord {

    @TableId
    private long id;

    @TableId
    private long circleId;

    @TableId
    private long userId;

    /**
     * 暂时不考虑文件等情况
     */
    String talkInfo;
}
