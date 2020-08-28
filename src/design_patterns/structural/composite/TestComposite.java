package design_patterns.structural.composite;

import java.util.ArrayList;

public class TestComposite {
    public static void main(String[] args) {
        AbstractFile file1, file2, file3, file4, file5;
        Folder folder1, folder2, folder3, folder4;

        folder1 = new Folder("Sunny的资料");
        folder2 = new Folder("图像文件");
        folder3 = new Folder("文本文件");
        folder4 = new Folder("视频文件");

        file1 = new ImageFile("小龙女.jpg");
        file2 = new ImageFile("张无忌.gif");
        file3 = new TextFile("九阴真经.txt");
        file4 = new TextFile("葵花宝典.doc");

        folder2.add(file1);
        folder2.add(file2);
        folder3.add(file3);
        folder3.add(file4);
        folder1.add(folder2);
        folder1.add(folder3);
        folder1.add(folder4);

        //从“Sunny的资料”节点开始进行杀毒操作
        folder1.killVirus();
    }
}

abstract class AbstractFile {
    public abstract void killVirus();
}

class ImageFile extends AbstractFile {
    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("Checking image " + name);
    }
}

class TextFile extends AbstractFile {
    private String name;

    public TextFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("Checking text file " + name);
    }
}

class Folder extends AbstractFile {
    private ArrayList<AbstractFile> fileList = new ArrayList<AbstractFile>();
    private String name;

    public Folder(String name) {
        this.name = name;
    }

    public void add(AbstractFile file) {
        fileList.add(file);
    }

    public void remove(AbstractFile file) {
        fileList.remove(file);
    }

    public AbstractFile getChild(int i) {
        return fileList.get(i);
    }

    @Override
    public void killVirus() {
        for (AbstractFile file : fileList) {
            file.killVirus();
        }
    }
}