package com.semihshn.passengerservice.adapter.api.retrofit;

import com.google.gson.JsonElement;
import com.semihshn.passengerservice.domain.port.PaymentPort;
import retrofit2.Call;
import retrofit2.http.*;

public interface IPaymentService extends PaymentPort {

    @POST("/api/payments")
    Call<JsonElement> savePayment(@Body JsonElement requestBody);

    @DELETE("/api/payments/{paymentId}")
    Call<Void> deletePayment(@Path("paymentId") Long paymentId);

    @GET("/api/payments/{paymentId}")
    Call<JsonElement> getPaymentById(@Path("paymentId") Long paymentId);
}
