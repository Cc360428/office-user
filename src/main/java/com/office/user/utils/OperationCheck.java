package com.office.user.utils;

public class OperationCheck {

	/**
	 * 校验数据拥有者是否是当前用户
	 * @author Cc
	 * @time 2019年5月30日 下午15:52:05
	 * @param uid 数据拥有者ID
	 * @return
	 */
	public static boolean isOwnerCurrentUser(int uid){
		if(uid == LoginSessionHelper.getCurrentUserId()){
			return true;
		}
		return false;
	}

}
