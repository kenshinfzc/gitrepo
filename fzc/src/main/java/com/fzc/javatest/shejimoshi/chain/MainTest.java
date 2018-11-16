package com.fzc.javatest.shejimoshi.chain;

/*
 责任链模式：如果有多个对象都有机会处理请求，责任链可使请求的发送者和接收者解耦，请求沿着责任链传递，直到有一个对象处理了它为止。
优点：
	 将请求的发送者和接收者解耦，使多个对象都有机会处理这个请求
	 可以简化对象，因为它无须知道链的结构
	 可以动态地增加或删减处理请求的链结构
缺点：
	 请求从链的开头进行遍历，对性能有一定的损耗
	 并不保证请求一定被处理
适用场合：
	 有多个对象可以处理一个请求
	 不明确接收者的情况
	 有序、无序链，线型、树形、环形链
责任链模式和状态模式主要区别：
	 责任链模式注重请求的传递
	 状态模式注重对象状态的转换
 */
public class MainTest {

	public static void main(String[] args) {
		Client mClient=new Client();
		Approver GroupLeader=new GroupApprover("Tom");
		Approver DepartmentLeader=new DepartmentApprover("Jerry");
		Approver VicePresident=new VicePresidentApprover("Kate");
		Approver President=new PresidentApprover("Bush");
		
		GroupLeader.SetSuccessor(VicePresident);
		DepartmentLeader.SetSuccessor(President);
		VicePresident.SetSuccessor(DepartmentLeader);
		President.SetSuccessor(GroupLeader);
		
		VicePresident.ProcessRequest(mClient.sendRequst(1, 100, 40));
		VicePresident.ProcessRequest(mClient.sendRequst(2, 200, 40));
		VicePresident.ProcessRequest(mClient.sendRequst(3, 300, 40));
		VicePresident.ProcessRequest(mClient.sendRequst(4, 400, 140));
		
		
	}
}
