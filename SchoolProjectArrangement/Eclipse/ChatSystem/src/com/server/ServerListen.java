package com.server;

/**
 * @author jie
 * @action:
 * @time:2015��12��22��
 */
public class ServerListen extends Thread
{
	ServerLink serverlink;
	public ServerListen(ServerLink serverlink)
	{
		this.serverlink=serverlink;
	}
	@Override
	public void run()
	{
		while(true)
		{
			int i=serverlink.userlinklist.getUserlinklist().size();
			serverlink.chatserver.getLblNewLabel().setText("�����û�"+i+"��");
		}
		
	}
}
