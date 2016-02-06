package deep;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.IOException;

public class Upper extends BodyTagSupport {
    BodyContent bodyContent;

    @Override
    public void setBodyContent(BodyContent bodyContent) {
        this.bodyContent = bodyContent;
    }

    @Override
    public int doAfterBody() throws JspException {
        try {
            String s1 = bodyContent.getString();
            JspWriter out = bodyContent.getEnclosingWriter();
            s1 = s1.toUpperCase();
            out.print(s1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            out.print("It should be printed <br />");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_BODY_AGAIN;
    }
}