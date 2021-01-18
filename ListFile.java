import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListFile {
    public static void main(String[] args) {
        File dir=new File("D:\\javaCodecode");
        List<File> files=listDir(dir);
        //jdk1.8集合框架使用stream操作，可以使用lambda表达式
        files.stream()
                .forEach(System.out::println);
    }
    public static List<File> listDir(File dir){
        List<File> list=new ArrayList<>();
        if(dir.isFile()){//效率不太好的地方，如果是文件，只返回一个list只存一个元素
            list.add(dir);
        }else if(dir.isDirectory()){
            File[] children=dir.listFiles();
            if(children!=null){
                for(File child:children){
                    List<File> files=listDir(child);
                    list.addAll(files);
                }
            }
        }
        return list;
    }
    public static List<File> listDir2(File dir) {
        List<File> list = new ArrayList<>();
        if (dir.isFile()) {//效率不太好的地方，如果是文件，只返回一个list只存一个元素
            return null;
        } else if (dir.isDirectory()) {
            File[] children = dir.listFiles();
            if (children != null) {
                for (File child : children) {
                    List<File> files = listDir2(child);
                    list.addAll(files);
                }
            }
        }
        return list;
    }
    public static List<File> listDir3(File dir) {
        List<File> list=new ArrayList<>();
        if (dir.isDirectory()) {
            //获取目录下一级的子文件或者子文件夹
        File[] children=dir.listFiles();
        if(children!=null){
            for(File child:children){
         /*       //返回的文件列表不包含文件夹
                if(child.isDirectory()){//如果是子文件夹，再次递归调用获取
                    list.addAll(listDir3(child));
                }else{
                    list.add(child);
                }*/

                //如果要包含
                list.add(child);
                if(child.isDirectory()) {//如果是子文件夹，再次递归调用获取
                    list.addAll(listDir3(child));
                }
            }
          }
        }
        return null;
    }
}
