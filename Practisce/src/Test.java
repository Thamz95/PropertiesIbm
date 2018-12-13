import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
	
	interface HelloWorld {
		String hello(String name);
	}

	public static void main(String[] args) {	      
		 HelloWorld helloWorld = (String name) -> { return "Hello " + name; };
		 
		 System.out.println(helloWorld.hello("Joe"));
		 
		 StringBuilder test = new StringBuilder(String.valueOf(true));
		 test.append("")
		 .append("!")
		 .append("dsfdsf");
		 
		 String va ="HSTNTX01";
		 System.out.println("CLLi length-- "+va.length());
		 
		 String  vvv = va.substring(0, 4);
		 
		 String checkkk = "afad_afdsd_safsaf_fa";
		 System.out.println("checkkk--"+checkkk.replaceAll("_", ""));
		 
		 System.out.println("vvv--"+vvv);
		 System.out.println("test--"+test);
		 
		 int intv = 10;
		 long longv = intv;
		 
		 System.out.println("longv--"+longv);
		 List<String> strl = Arrays.asList("tttt","yyyyyyyy","uuuu");
		 
		 strl.stream().map(e->e.toString()).collect(Collectors.joining("'"+","+"'"));
		 System.out.println("String.join--"+strl.stream().map(e->e.toString()).collect(Collectors.joining(",")));
		 System.out.println("String.join--"+String.join(",", strl));
		// checkQuery();
		 
	}

	public static void  checkQuery() {
		
		String inOrderSource ="gfgf";
		String inOrderNumber ="dfssd";
		String inSuppVersionNumber ="dfssf";
		
		StringBuilder stringQuery = new StringBuilder();
		 
		 stringQuery.append("SELECT distinct gatewayCityCode || substr(pbxBeginRange,1,3) ")
			.append(" FROM SiteTnDelta WHERE ")
			.append(" orderSource =").append("'"+inOrderSource+"'")
			.append(" AND orderNumber =").append("'"+inOrderNumber+"'")
			.append(" AND suppVersionNumber =").append("'"+inSuppVersionNumber+"'")
			.append(" AND length(gatewayCityCode) =").append(3)
			.append(" AND portedNative = 'P'")
			.append(" AND actionCode = 'A'");
		
		 System.out.println("Query print == " +stringQuery.toString());
		 
		 List<String> alist = new ArrayList<>();
		 alist.add("check");
		 alist.add("check1");
		 
		 System.out.println("alist data == " +alist.toString());
		 
	}
}
