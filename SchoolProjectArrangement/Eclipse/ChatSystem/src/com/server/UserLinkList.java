package com.server;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jie
 * @action:
 * @time:2015��12��22��
 */
public class UserLinkList
{
	private ArrayList<Socket> Userlinklist=new ArrayList<Socket>();

	public List<Socket> getUserlinklist()
	{
		return Userlinklist;
	}
}
