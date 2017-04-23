package sadden.wenzhai.test;

import java.util.concurrent.Callable;

import matlabcontrol.MatlabConnectionException;
import matlabcontrol.MatlabProxy;
import matlabcontrol.MatlabProxyFactory;

public  class MatlabCaller implements Callable{

	private static 	MatlabCaller instance;
	private static MatlabProxy proxy;
	private static Object SYN_ROOT=new Object();
	
	public static MatlabCaller getInstance()
	{
		if(instance == null)
		{
			synchronized (SYN_ROOT)
			{
				if(instance==null)
				{
					instance= new MatlabCaller();
				}
			}
		}
		return instance;
	}
	
	private MatlabCaller()
	{
		if(proxy == null)
		{
			MatlabProxyFactory factory =new MatlabProxyFactory();
			try
			{
				proxy = factory.getProxy();
			}
			catch(MatlabConnectionException e)
			{
				e.printStackTrace();
			}
			
		}
	}
	


	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Matlabcaller called");
		return null;
	}
	
	
	
	
}
