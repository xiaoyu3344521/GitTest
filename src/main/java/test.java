import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
public static void main(String[] args) {
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
	System.out.println(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
}
}
