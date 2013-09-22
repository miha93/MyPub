package com.teamdev.mypub.async;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.teamdev.mypub.ApplicationParameters;
import com.teamdev.mypub.utils.StringUtils;

import android.content.Context;
import android.os.AsyncTask;
import android.provider.Settings;
import android.widget.Toast;

public class AsyncRegister extends AsyncTask<Void, Void, Boolean> {

	private Context mContext;

	public AsyncRegister(Context context) {
		mContext = context;
	}

	@Override
	protected Boolean doInBackground(Void... params) {
		HttpParams httpParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParams,
				ApplicationParameters.CONNECTION_TIMEOUT);
		HttpConnectionParams.setSoTimeout(httpParams,
				ApplicationParameters.CONNECTION_TIMEOUT);
		HttpClient client = new DefaultHttpClient(httpParams);

		HttpPost request = new HttpPost(ApplicationParameters.SERVER_ADDRESS);

		String device_id = Settings.Secure.getString(
				mContext.getContentResolver(), Settings.Secure.ANDROID_ID);

		try {
			JSONObject jsonParams = new JSONObject();
			jsonParams.put("method", "register");
			JSONObject innerParams = new JSONObject();
			innerParams.put("device_id", device_id);
			innerParams.put("device_type", "Android");
			innerParams.put("device_token", "");

			jsonParams.put("params", innerParams);
			request.setEntity(new ByteArrayEntity(jsonParams.toString()
					.getBytes("UTF8")));
			HttpResponse response = client.execute(request);

			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				return true;
			} else {
				return false;
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	protected void onPostExecute(Boolean result) {
		super.onPostExecute(result);
		if (!result) {
			Toast.makeText(mContext, "Register Has Failed", Toast.LENGTH_LONG)
					.show();
		}
	}

}
