package me.xlever.miaosha.result;

public class Result<T> {
    private int code;
    private String msg;
    private T data;

    private Result(T data){
        this.code=0;
        this.msg="success";
        this.data=data;
    }

    public Result(CodeMsg codeMsg) {
        if(codeMsg==null){
            return;
        }
        this.code=codeMsg.getCode();
        this.msg=codeMsg.getMsg();
    }

    /**
     * 成功时候的调用
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data){
        return new Result<T>(data);
    }

    /**
     * 失败时候的调用
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(CodeMsg codeMsg){
        return new Result<T>(codeMsg);
    }
    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

}
