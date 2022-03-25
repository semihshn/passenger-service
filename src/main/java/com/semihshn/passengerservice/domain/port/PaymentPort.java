package com.semihshn.passengerservice.domain.port;

import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Path;

public interface PaymentPort {

    Call<JsonElement> savePayment(@Body JsonElement requestBody);

    Call<Void> deletePayment(@Path("paymentId") Long paymentId);

    Call<JsonElement> getPaymentById(@Path("paymentId") Long paymentId);
}
