package com.teamdev.mypub.async;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
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
import com.teamdev.mypub.R;
import com.teamdev.mypub.interfaces.GetPlacesListener;
import com.teamdev.mypub.models.Place;
import com.teamdev.mypub.utils.StringUtils;

import android.content.Context;
import android.os.AsyncTask;
import android.provider.Settings;

public class AsyncGetPubs extends AsyncTask<Void, Void, List<Place>> {

	private Context mContext;
	private GetPlacesListener mListener;

	public AsyncGetPubs(Context context, GetPlacesListener listener) {
		mContext = context;
		mListener = listener;
	}

	@Override
	protected List<Place> doInBackground(Void... params) {
		HttpParams httpParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParams,
				ApplicationParameters.CONNECTION_TIMEOUT);
		HttpConnectionParams.setSoTimeout(httpParams,
				ApplicationParameters.CONNECTION_TIMEOUT);
		HttpClient client = new DefaultHttpClient(httpParams);

		HttpPost request = new HttpPost(ApplicationParameters.SERVER_ADDRESS);
		
		List<Place> places = new ArrayList<Place>();

		try {
			JSONObject jsonParams = new JSONObject();
			jsonParams.put("method", "get_place_list");
			JSONObject innerParams = new JSONObject();

			innerParams.put("latitude", 34.1);
			innerParams.put("longitude", 35.0);
			innerParams.put("radius", 200);

			jsonParams.put("params", innerParams);

			request.setEntity(new ByteArrayEntity(jsonParams.toString()
					.getBytes("UTF8")));
			HttpResponse response = client.execute(request);

			InputStream instream = response.getEntity().getContent();
			JSONObject jsonResponse = new JSONObject(
					StringUtils.convertStreamToString(instream));

			// Get the query value
			JSONArray placesJson = jsonResponse.getJSONArray("places");

			for (int i = 0; i < placesJson.length(); i++) {
				JSONObject json = placesJson.getJSONObject(i);
				
				Place p = new Place();
				p.setName(json.getString("name"));
				p.setAddress(json.getString("address"));
				p.setId(json.getInt("id"));
				p.setVoteInProgress(json.getBoolean("vote_in_progress"));
				p.setIcon(mContext.getResources().getDrawable(
						R.drawable.pub_icon));
				
				places.add(p);
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} finally {
			return places;
		}
	}

	@Override
	protected void onPostExecute(List<Place> result) {
		super.onPostExecute(result);
		if (result.size() != 0) {
			mListener.setPlaces(result);
		} else {
			List<Place> place = new ArrayList<Place>();
			Place p = new Place();
			p.setName("Error Bar");
			p.setAddress("Error Bar");
			p.setId(0);
			p.setVoteInProgress(false);
			p.setIcon(mContext.getResources().getDrawable(
					R.drawable.pub_icon));
			place.add(p);
			mListener.setPlaces(place);
		}
	}

}
