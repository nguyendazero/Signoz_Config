package com.haibazo.bff.mock.webapi.service;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Tracer;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    private static final Tracer tracer = GlobalOpenTelemetry.getTracer("its-rct-api-mock");

    public void trackEvent() {
        // Bắt đầu một span
        var span = tracer.spanBuilder("trackEvent").startSpan();
        try {
            // Logic ghi nhận sự kiện
            // Ví dụ: bạn có thể thêm thông tin vào span
            span.addEvent("Tracking event started");

            // Giả lập một hành động nào đó, ví dụ: lưu vào cơ sở dữ liệu
            // Một số logic nghiệp vụ ở đây
            // ...

            span.addEvent("Tracking event completed");
        } catch (Exception e) {
            // Nếu có lỗi, ghi lại thông tin lỗi vào span
            span.recordException(e);
        } finally {
            span.end(); // Kết thúc span
        }
    }
}