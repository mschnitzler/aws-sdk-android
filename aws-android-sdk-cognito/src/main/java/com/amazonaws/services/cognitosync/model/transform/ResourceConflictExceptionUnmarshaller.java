/*
 * Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.amazonaws.services.cognitosync.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler.JsonErrorResponse;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.*;
import com.amazonaws.transform.*;
import com.amazonaws.util.json.AwsJsonReader;

import com.amazonaws.services.cognitosync.model.ResourceConflictException;

public class ResourceConflictExceptionUnmarshaller extends JsonErrorUnmarshaller {

    public ResourceConflictExceptionUnmarshaller() {
        super(ResourceConflictException.class);
    }

    @Override
    public boolean match(JsonErrorResponse error) throws Exception {
        return error.getErrorCode().equals("ResourceConflictException");
    }

    @Override
    public AmazonServiceException unmarshall(JsonErrorResponse error) throws Exception {

        ResourceConflictException e = (ResourceConflictException) super.unmarshall(error);
        e.setErrorCode("ResourceConflictException");

        return e;
    }

    public ResourceConflictException unmarshall(JsonUnmarshallerContext context) throws Exception {
        AwsJsonReader reader = context.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }

        // The `getMessage` method of AWSServiceException derives its value from
        // `errorMessage`. The incoming context
        // has the value in `message`, so we'll have a special case to handle
        // that.
        ResourceConflictException resourceConflictException = new ResourceConflictException(
                "No message provided.");
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if ("message".equals(name)) {
                resourceConflictException.setErrorMessage(StringJsonUnmarshaller.getInstance()
                        .unmarshall(context));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return resourceConflictException;
    }
}
