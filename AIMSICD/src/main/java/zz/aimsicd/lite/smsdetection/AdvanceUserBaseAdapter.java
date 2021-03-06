/* Android IMSI-Catcher Detector | (c) AIMSICD Privacy Project
 * -----------------------------------------------------------
 * LICENSE:  http://git.io/vki47 | TERMS:  http://git.io/vki4o
 * -----------------------------------------------------------
 */

/* Coded by Paul Kinsella <paulkinsella29@yahoo.ie> */

package zz.aimsicd.lite.smsdetection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import zz.aimsicd.lite.R;


public class AdvanceUserBaseAdapter extends BaseAdapter {
    private static List<AdvanceUserItems> detectionItemDetails;

    private LayoutInflater l_Inflater;

    public AdvanceUserBaseAdapter(Context context, List<AdvanceUserItems> results) {
        detectionItemDetails = results;
        l_Inflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return detectionItemDetails.size();
    }

    public Object getItem(int position) {
        return detectionItemDetails.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = l_Inflater.inflate(R.layout.adv_user_strings_list, parent, false);
            holder = new ViewHolder();
            holder.tv_detection_string = (TextView) convertView.findViewById(R.id.tv_adv_list_det_str);
            holder.tv_detection_type = (TextView) convertView.findViewById(R.id.tv_adv_list_det_type);


            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        holder.tv_detection_string.setText(detectionItemDetails.get(position).getDetection_string());
        holder.tv_detection_type.setText(detectionItemDetails.get(position).getDetection_type());
        return convertView;
    }

    static class ViewHolder {

        TextView tv_detection_string,
                tv_detection_type;
    }
}
