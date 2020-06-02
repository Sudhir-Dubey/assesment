package com.fincovi.assessment.resource;

import java.io.Serializable;

/**
 *
 * assessment
 *
 * @author sudhir kumar dubey
 * @since May 22, 2020
 * @copyright Copyright (c) 2020 - Fincovi - All Rights Reserved
 */
public class ResponseResource<T> implements Serializable
{

    private ResultType result;

    private transient T data;

    public enum ResultType
    {
        ERROR, SUCCESS, WARNING;
    }

    public ResponseResource()
    {
        this.result = ResultType.SUCCESS;
    }

    public ResponseResource(final T data)
    {
        this.data = data;
        this.result = ResultType.SUCCESS;

    }

    /**
     * @return the result
     */
    public ResultType getResult()
    {
        return this.result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(final ResultType result)
    {
        this.result = result;
    }

    /**
     * @return the data
     */
    public T getData()
    {
        return this.data;
    }

    /**
     * @param data the data to set
     */
    public void setData(final T data)
    {
        this.data = data;
    }

    @Override
    public String toString()
    {
        final StringBuilder builder = new StringBuilder();
        builder.append("Response [result=");
        builder.append(this.result);
        builder.append(", data=");
        builder.append(this.data);
        builder.append("]");
        return builder.toString();
    }

}

