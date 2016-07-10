package eu.chargetime.ocpp.model;

/*
 * ChargeTime.eu - Java-OCA-OCPP
 *
 * MIT License
 *
 * Copyright (C) 2016 Thomas Volden <tv@chargetime.eu>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

/**
 * Sent by the Central System to the Charge Point in response to a {@link StartTransactionRequest}.
 */
public class StartTransactionConfirmation implements Confirmation {
    private IdTagInfo idTagInfo;
    private Integer transactionId;

    @Override
    public boolean validate() {
        boolean valid = true;
        if (valid &= idTagInfo != null)
            valid &= idTagInfo.validate();
        return valid;
    }

    /**
     * This contains information about authorization status, expiry and parent id.
     *
     * @return the {@link IdTagInfo}.
     */
    public IdTagInfo getIdTagInfo() {
        return idTagInfo;
    }

    /**
     * Required. This contains information about authorization status, expiry and parent id.
     *
     * @param idTagInfo the {@link IdTagInfo}.
     */
    public void setIdTagInfo(IdTagInfo idTagInfo) {
        this.idTagInfo = idTagInfo;
    }

    /**
     * This contains the transaction id supplied by the Central System.
     *
     * @return transaction id.
     */
    public Integer getTransactionId() {
        return transactionId;
    }

    /**
     * Required. This contains the transaction id supplied by the Central System.
     *
     * @param transactionId integer, transaction.
     */
    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }
}