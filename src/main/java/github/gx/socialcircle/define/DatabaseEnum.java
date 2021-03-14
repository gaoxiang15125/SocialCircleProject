package github.gx.socialcircle.define;

import lombok.Getter;

/**
 * @program: socialcircle
 * @description: 数据库数据相关枚举值
 * @author: gaoxiang
 * @email: 630268696@qq.com
 * @create: 2021-03-14 11:05
 **/
public class DatabaseEnum {

    @Getter
    public enum SEX_TYPE {
        boy(0, "男"), girl(1, "女"), secret(-1,"保密");

        int code;
        String sexStr;
        SEX_TYPE(int type, String sexStr) {
            this.code = type;
            this.sexStr = sexStr;
        }

        public SEX_TYPE getSexByCode(int code) {
            for(SEX_TYPE sexType:SEX_TYPE.values()) {
                if(sexType.getCode() == code) {
                    return sexType;
                }
            }
            return secret;
        }

        public SEX_TYPE getSexByStr(String sexStr) {
            for(SEX_TYPE sexType:SEX_TYPE.values()) {
                if(sexType.getSexStr().equals(sexStr)) {
                    return sexType;
                }
            }
            return secret;
        }
    }

    @Getter
    public enum MEMBER_TYPE {

        member(0,"成员"),QManager(1,"管理员"),QLeader(2,"圈主");

        String memberStr;
        int code;
        MEMBER_TYPE(int code, String memberStr) {
            this.code = code;
            this.memberStr = memberStr;
        }

        public MEMBER_TYPE getTypeByCode(int code) {
            for(MEMBER_TYPE memberType: MEMBER_TYPE.values()) {
                if(memberType.getCode() == code) {
                    return memberType;
                }
            }
            return member;
        }

        public MEMBER_TYPE getTypeByStr(String memberStr) {
            for(MEMBER_TYPE memberType: MEMBER_TYPE.values()) {
                if(memberType.getMemberStr().equals(memberStr)) {
                    return memberType;
                }
            }
            return member;
        }
    }
}
