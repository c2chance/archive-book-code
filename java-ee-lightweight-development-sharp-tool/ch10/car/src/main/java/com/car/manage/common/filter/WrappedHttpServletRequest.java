package com.car.manage.common.filter;

import com.google.common.io.ByteStreams;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * wrap request.
 */
public class WrappedHttpServletRequest extends HttpServletRequestWrapper {
    private byte[] bytes;

    /**
     * wrap request.
     *
     * @param request http servlet request
     * @throws IOException io exception
     */
    public WrappedHttpServletRequest(HttpServletRequest request) throws IOException {
        super(request);
        // 读取输入流里的请求参数，并保存到bytes里
        bytes = ByteStreams.toByteArray(request.getInputStream());
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        return new WrappedServletInputStream(byteArrayInputStream);
    }

    @Override
    public BufferedReader getReader() throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        return new BufferedReader(new InputStreamReader(byteArrayInputStream));
    }

    private class WrappedServletInputStream extends ServletInputStream {
        private InputStream stream;

        /**
         * wrapped stream.
         *
         * @param stream stream
         */
        WrappedServletInputStream(InputStream stream) {
            this.stream = stream;
        }

        @Override
        public int read() throws IOException {
            return stream.read();
        }

        @Override
        public boolean isFinished() {
            return true;
        }

        @Override
        public boolean isReady() {
            return true;
        }

        @Override
        public void setReadListener(ReadListener readListener) {
        }
    }
}
