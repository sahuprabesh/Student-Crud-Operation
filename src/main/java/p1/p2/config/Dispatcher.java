package p1.p2.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Dispatcher extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("rootconfig class method");
		return new Class[] {RootApp.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("getServletConfigclasses");
		return new Class[]{Configgg.class};
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("mapping");

		return new String[]{"/"};
	}

}
