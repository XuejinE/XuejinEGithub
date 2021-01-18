import java.io.*;

public class FileInput {

    public static void main(String[] args) throws IOException {
      /*  File file =new File("C:\\Users\\lenovo\\Pictures");
        //文件输入字节流
        FileInputStream fis=new FileInputStream(file);
        //输入流比较固定的写法：读取到一个字节/字符数组。定义read的返回值变量，while
        byte[] bytes=new byte[1024];
        int len=0;
        ////读取到的长度，数组可能读满，也可能没读满，当次读取，一般使用数组【0，len】
        while((len=fis.read(bytes))!=-1){
            String str=new String(bytes,0,len);//模拟
            System.out.println(str);

        }
        //一般来说，输入输出流使用完，一定要关闭，关闭的顺序是反向关系，和创建的顺序相反)*/


       /* //2.文件的输入字符流
        File file =new File("C:\\Users\\lenovo\\Pictures");
        FileReader fr=new FileReader(file);
        char[] chars=new char[1024];
        int len=0;
        while((len=fr.read(chars))!=-1){
            String str=new String(bytes,0,len);//模拟
            System.out.println(str);
        }*/

        //3.缓冲流：缓冲的字节输入，缓冲字符输入
        File file = new File("C:\\Users\\lenovo\\Pictures");
        FileInputStream fis = new FileInputStream(file);//文件字节输入流
        InputStreamReader isr = new InputStreamReader(fis);//字节流转字符流，一定要经过字节字符转换流来转换，并且可以指定编码
        BufferedReader br = new BufferedReader(isr);
        String str;
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }
        //释放资源：反向释放
        br.close();
        isr.close();
        fis.close();
    }
}
