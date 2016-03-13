package com.then.littlepoint.api.http.ex;


import com.then.littlepoint.event.UploadAndDownLoadEvent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.greenrobot.eventbus.EventBus;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

/**
 * Created by 42524 on 2016/1/20.
 */
public class ProgressRequestBody extends RequestBody {
    private File mFile;
    private String mPath;

    private static final int DEFAULT_BUFFER_SIZE = 2048;


    public ProgressRequestBody(final File file) {
        mFile = file;
    }

    @Override
    public MediaType contentType() {
        // i want to upload only images
        return MediaType.parse("image/*");
    }

    @Override
    public void writeTo(BufferedSink sink) throws IOException {
        long fileLength = mFile.length();
        byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
        FileInputStream in = new FileInputStream(mFile);
        long uploaded = 0;
        try {
            int read;
            while ((read = in.read(buffer)) != -1) {
                EventBus.getDefault().post(new UploadAndDownLoadEvent(uploaded,fileLength,UploadAndDownLoadEvent.ING));
                uploaded += read;
                sink.write(buffer, 0, read);
            }
            EventBus.getDefault().post(new UploadAndDownLoadEvent(UploadAndDownLoadEvent.SUCCESS));
        }
        catch (Exception e){
            EventBus.getDefault().post(new UploadAndDownLoadEvent(UploadAndDownLoadEvent.FILED));
        }
        finally {
            in.close();
        }
    }

}
