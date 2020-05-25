package js;

import javax.script.*;

public class TestJS {

    public static void main(String[] args) {
        TestJS test = new TestJS();
//        test.testJSCore();
//        test.callJsObjectFunc();
//        test.runnableImpl();
        test.multiScopes();
    }

    public void testJSCore() {
        // 初始化JS脚本引擎
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine =  factory.getEngineByName("JavaScript");
        // 注入全局变量 a = 4, b = 9
        engine.put("a", 4);
        engine.put("b", 9);
        // 执行 max_num(a, b), a 和 b 对应上面设置的全局变量
        Object maxNum = null;
        try {
            maxNum = engine.eval("function max_num(a,b){return (a>b)?a:b;}max_num(a,b);");
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        System.out.println("max_num: " + maxNum);
    }

    public void callJsObjectFunc() {
        // 初始化JS脚本引擎
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine =  factory.getEngineByName("JavaScript");
        StringBuffer script = new StringBuffer();
        script.append("var obj = new Object();");
        script.append("obj.hello = function(name){print('hello, '+name);}");
        //执行这段script脚本
        try {
            engine.eval(script.toString());
            // JavaScript engine实现了Invocable接口
            Invocable invocable = (Invocable)engine;
            // 获取我们想调用那个方法所属的js对象
            Object obj = engine.get("obj");
            // 执行obj对象的名为hello的方法
            invocable.invokeMethod(obj, "hello", "js method");

        } catch (ScriptException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    // 使用script实现Java接口
    public void runnableImpl() {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        // String 里面定义一段JS代码脚本
        String script = "function run() { print('run called'); }";
        // 执行这个脚本
        try {
            engine.eval(script);
            // 从脚本引擎中获取Runnable接口对象的实例，该接口方法由相匹配名称的脚本函数实现
            Invocable invocable = (Invocable)engine;
            // 在上面脚本中，已经实现了Runnable接口的run方法
            Runnable runnable = invocable.getInterface(Runnable.class);

            // 启动一个线程运行
            Thread thread = new Thread(runnable);
            thread.start();
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    // 脚本引擎的多个scope
    public void multiScopes() {
        // 初始化脚本引擎
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        // 打印全局变量 x
        engine.put("x", "hello world");
        try {
            engine.eval("print(x);");

            // 传入一个不同的script context
            ScriptContext context = new SimpleScriptContext();
            // 新的Script context 绑定 ScriptContext 的 ENGINE_SCOPE
            Bindings bindings = context.getBindings(ScriptContext.ENGINE_SCOPE);

            // 增加一个新变量到新的范围 engineScope中
            bindings.put("x", "world hello");

            // 执行同一个脚本，但这次传入一个不同的script context
            engine.eval("print(x);", bindings);
            engine.eval("print(x);");
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

}
