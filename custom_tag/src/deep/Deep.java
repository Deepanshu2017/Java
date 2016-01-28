package deep;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.IOException;

public class Deep extends TagSupport {

    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            out.print("My name is Deepanshu Thakur");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}