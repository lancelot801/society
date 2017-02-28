package cn.joongky.society;

public class JsonResult {
	private Integer resultCode;
	private Object resultData;
	
	public JsonResult() {
		super();
	}

	public JsonResult(Integer code, Object data) {
		this.resultCode = code;
		this.resultData = data;
	}

	public Integer getResultCode() {
		return resultCode;
	}

	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}

	public Object getResultData() {
		return resultData;
	}

	public void setResultData(Object resultData) {
		this.resultData = resultData;
	}
}