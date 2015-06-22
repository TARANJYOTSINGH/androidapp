package com.apppartner.androidprogrammertest.adapters;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.apppartner.androidprogrammertest.R;
import com.apppartner.androidprogrammertest.models.ChatData;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created on 12/23/14.
 *
 * @author Thomas Colligan
 */
public class ChatsArrayAdapter extends ArrayAdapter<ChatData>
{
    public ChatsArrayAdapter(Context context, List<ChatData> objects)
    {
        super(context, 0, objects);
    }
    public void download(String url, ImageView imageView) {
        BitmapDownloaderTask task = new BitmapDownloaderTask(imageView);
        task.execute(url);
    }



    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ImageLoader imageLoader = ImageLoader.getInstance();
        ChatCell chatCell = new ChatCell();

        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.cell_chat, parent, false);

        chatCell.usernameTextView = (TextView) convertView.findViewById(R.id.usernameTextView);
        chatCell.messageTextView = (TextView) convertView.findViewById(R.id.messageTextView);
        chatCell.userImage=(ImageView) convertView.findViewById(R.id.userImage);
        ChatData chatData = getItem(position);

        //Bitmap bmp = imageLoader.loadImageSync(chatData.avatarURL);

        download(chatData.avatarURL,chatCell.userImage);
        chatCell.usernameTextView.setText(chatData.username);
        chatCell.messageTextView.setText(chatData.message);
        //chatCell.userImage.setImageBitmap(getRoundedShape(bmp));





        return convertView;
    }

    private static class ChatCell
    {
         ImageView userImage;
        TextView usernameTextView;
        TextView messageTextView;
    }



}
