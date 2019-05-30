/**
 * Title:
 * Description:
 * @author Cc
 * @version v1.0
 * @time 2019年5月30日 上午10:52:58
 */
package com.office.user.utils.lock;

/**
 * Title: 分布式锁接口
 * @author Cc
 * @version v1.0
 * @time 2019年5月30日 上午10:52:58
 */
public interface DistributedLock {
	
	/**
	 * 获取锁
	 * @author Cc
	 * @time 2019年5月30日 上午11:02:54
	 * @return
	 * @throws InterruptedException
	 */
	public boolean acquire();
	
	/**
	 * 释放锁
	 * @author Cc
	 * @time 2019年5月30日 上午11:02:59
	 */
	public void release();
	
}
