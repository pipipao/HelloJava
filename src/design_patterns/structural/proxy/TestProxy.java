package design_patterns.structural.proxy;

public class TestProxy {
    public static void main(String[] args) {
        Proxy proxy=new Proxy();
        proxy.request();
    }
}
abstract class AbstractSubject{
    public abstract void request();
}
class RealSubject extends AbstractSubject{
    @Override
    public void request() {
        System.out.println("Real request");
    }
}
class PreRequest{
    public void preRequest(){
        System.out.println("PreRequest");
    }
}
class PostRequest{
    public void postRequest(){
        System.out.println("PostRequest");
    }
}
class Proxy extends AbstractSubject{
    private PreRequest preRequest=new PreRequest();
    private  RealSubject realSubject=new RealSubject();
    private PostRequest postRequest=new PostRequest();

    @Override
    public void request() {
        preRequest();
        realSubject.request();
        postRequest();
    }
    public void preRequest(){
        preRequest.preRequest();
    }
    public void postRequest(){
        postRequest.postRequest();
    }
}