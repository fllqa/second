package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.user;
import Util.BaseDao;
import Util.DBUtils;
import connectionBase.BaseUtils;
import net.sf.json.JSONObject;


@WebServlet("/userservlet")
public class userservlets extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userservlets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String method=request.getParameter("method");
		if ("insert".equals(method))
		{
			adduser(request,response);
		}
	}
	private void adduser(HttpServletRequest request,HttpServletResponse  response)
	{
		try
		{
			/*获取页面传来的值*/
			String username= request.getParameter("username");
			String password = request.getParameter("password");
			String sex = request.getParameter("sex");
			int age=Integer.parseInt(request.getParameter("age"));
			String birthday = request.getParameter("birthday");
			String city = request.getParameter("city");
			String salary = request.getParameter("salary");
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");
			String description = request.getParameter("description");
			//System.out.println(username+password+sex+age+birthday+city+salary+startTime+endTime+description);
			/*将数据分配给对象*/
			user user=new user();
			user.setUsername(username);
			user.setPassword(password);
			user.setSex(sex);
			user.setAge(age);
			user.setBirthday(birthday);
			user.setCity(city);
			user.setSalary(salary);
			user.setStartTime(startTime);
			user.setEndTime(endTime);
			user.setDescription(description);
			DBUtils.createConnection();
			BaseDao db=new BaseDao();
			db.insert1(user);
			/*往回页面写数据*/
			response.setContentType("text/html chartset=utf-8");
			//这里有两种方法，1josn对象，2拼接
			/*String res="{\"status\":\"ok\",\"message\":\"操作成功!\"}";
			 * try {
				response.getWriter().write(res);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 * */
			JSONObject res=new JSONObject();
			res.put("status", "ok");
			res.put("message", "操作成功");
			response.getWriter().write(res.toString());
			
		} 
		catch (Exception e)
		{
			JSONObject res=new JSONObject();
			res.put("status", "failed");
			res.put("message", "操作失败");
			try 
			{
				response.getWriter().write(res.toString());
			} catch (IOException e1)
			{
				
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		
		
		
		
			
	}
		
	
		
		
		
		
		
	}


