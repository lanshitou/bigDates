package com.tomsung.agdc.common;

public class ServiceException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ResultStatus resultStatus;
    private Object content;

    public ServiceException(ResultStatus resultStatus) {
        super(resultStatus.getMessage());
        this.resultStatus = resultStatus;
    }

    public ServiceException(ResultStatus resultStatus, Object content) {
        super(resultStatus.getMessage());
        this.resultStatus = resultStatus;
        this.content = content;
    }

    public ResultStatus getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(ResultStatus resultStatus) {
        this.resultStatus = resultStatus;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
