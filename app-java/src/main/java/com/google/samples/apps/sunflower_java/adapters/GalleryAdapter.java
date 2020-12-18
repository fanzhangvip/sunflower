package com.google.samples.apps.sunflower_java.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.google.samples.apps.sunflower_java.data.UnsplashPhoto;
import com.google.samples.apps.sunflower_java.databinding.ListItemPhotoBinding;


import java.util.Objects;


public class GalleryAdapter extends PagingDataAdapter<UnsplashPhoto, GalleryAdapter.GalleryViewHolder> {


    public GalleryAdapter(GalleryDiffCallback diffCallback) {
        super(diffCallback);
    }

    @Override
    public GalleryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GalleryViewHolder(ListItemPhotoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(GalleryViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    final static class GalleryDiffCallback extends DiffUtil.ItemCallback<UnsplashPhoto> {

        @Override
        public boolean areItemsTheSame(UnsplashPhoto oldItem, UnsplashPhoto newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(UnsplashPhoto oldItem, UnsplashPhoto newItem) {
            return Objects.equals(oldItem, newItem);
        }

        public GalleryDiffCallback() {
        }
    }


    final static class GalleryViewHolder extends RecyclerView.ViewHolder {

        private ListItemPhotoBinding binding;

        public GalleryViewHolder(ListItemPhotoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(UnsplashPhoto item) {
            binding.setPhoto(item);
            binding.executePendingBindings();
        }
    }
}


