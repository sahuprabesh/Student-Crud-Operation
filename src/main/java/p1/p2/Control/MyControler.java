package p1.p2.Control;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import p1.p2.domain.Dto;
import p1.p2.service.ServiceIntf;

@Controller
public class MyControler {

	@Autowired
	private ServiceIntf ServInterface;

	@RequestMapping("/")
	public String firstPage() {
		return "wel";
	}

	@RequestMapping("/putData")
	public String saveData(HttpServletRequest req, @RequestParam("t1") Integer id, @RequestParam("t2") String name,
			@RequestParam("t3") String addr, @RequestParam("t4") Double fee, Model m) {
		System.out.println("Controller Start");
		Dto dt = new Dto();
		dt.setId(id);
		dt.setName(name);
		dt.setAddr(addr);
		dt.setFee(fee);
		Dto result = ServInterface.storeStudent(dt);
		System.out.println("Controller" + id + " " + addr);
		// List studentList=new ArrayList<>();


		m.addAttribute("student", result);
		System.out.println("Controller End");
		return "registeredData";
	}

	@RequestMapping("/delet")
	public String deleteStudent(@RequestParam("sid") Integer id, HttpServletRequest req, Model m) {
		System.out.println("deleteStudent call......");
		System.out.println("Controller data" + id);
		HttpSession session = req.getSession();

		Integer deleteItem = ServInterface.cutStudenet(id);
		if (deleteItem == 1) {
			// session.removeAttribute(deleteItem);
			m.addAttribute("deleteId", deleteItem);
		}

		return "redirect:/showData";
	}
	
	@RequestMapping("/showData")
	public String showData(Model m)
	{
		System.out.println("Enter into Show Table");
		
		List<Dto> list=ServInterface.viewTable();
		System.out.println(list);
		if(list!=null)
		{
			m.addAttribute("students",list);
		}
		else
		{
			return null;
		}
		
		return "Previous";
	}
	
	@RequestMapping("/edit")
	public String editStudent(Model m,@RequestParam("id")Integer id,@RequestParam("name")String name,@RequestParam("addr")String addr,@RequestParam("fee")Double fee)
	{
		System.out.println("come into edit Handler method");
		Dto dt=new Dto();
		dt.setId(id);
		dt.setAddr(addr);
		dt.setName(name);
		dt.setFee(fee);
		
		m.addAttribute("student",dt);
		return "editPage";
	}
	
	@RequestMapping("/update")
	public String updateStudent(Model m,@RequestParam("t1")Integer id,@RequestParam("t2")String name,@RequestParam("t3")String addr,@RequestParam("t4")Double fee)
	{
		Dto dt=new Dto();
		
		dt.setAddr(addr);
		dt.setName(name);
		dt.setFee(fee);
		dt.setId(id);
		
		Dto dto=ServInterface.reInsert(dt);
		
		m.addAttribute("student",dto);
		
		return "redirect:/showData";
	}

}
