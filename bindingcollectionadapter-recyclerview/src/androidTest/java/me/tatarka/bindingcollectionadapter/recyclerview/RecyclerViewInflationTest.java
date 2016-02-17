package me.tatarka.bindingcollectionadapter.recyclerview;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.test.InstrumentationRegistry;
import android.support.v7.widget.RecyclerView;
import android.test.InstrumentationTestCase;
import android.test.UiThreadTest;
import android.view.LayoutInflater;

import java.util.Arrays;
import java.util.List;

import me.tatarka.bindingcollectionadapter.BindingRecyclerViewAdapter;
import me.tatarka.bindingcollectionadapter.ItemView;
import me.tatarka.bindingcollectionadapter.recyclerview.test.R;

import static org.assertj.core.api.Assertions.assertThat;

public class RecyclerViewInflationTest extends InstrumentationTestCase {

    private LayoutInflater inflater;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        inflater = LayoutInflater.from(getInstrumentation().getContext());
    }

    @UiThreadTest
    public void testRecyclerView() {
        List<String> items = Arrays.asList("one", "two", "three");
        TestHelpers.ViewModel viewModel = new TestHelpers.ViewModel(items, ItemView.of(BR.item, R.layout.item));
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, R.layout.recycler_view, null, false);
        binding.setVariable(BR.viewModel, viewModel);
        binding.executePendingBindings();

        RecyclerView recyclerView = (RecyclerView) binding.getRoot();
        @SuppressWarnings("unchecked")
        BindingRecyclerViewAdapter<String> adapter = (BindingRecyclerViewAdapter<String>) recyclerView.getAdapter();

        assertThat(TestHelpers.iterable(adapter)).containsExactlyElementsOf(items);
    }

    @UiThreadTest
    public void testRecyclerViewAdapter() {
        List<String> items = Arrays.asList("one", "two", "three");
        TestHelpers.ViewModel viewModel = new TestHelpers.ViewModel(items, ItemView.of(BR.item, R.layout.item));
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, R.layout.recycler_view_adapter, null, false);
        binding.setVariable(BR.viewModel, viewModel);
        binding.executePendingBindings();

        RecyclerView recyclerView = (RecyclerView) binding.getRoot();
        @SuppressWarnings("unchecked")
        BindingRecyclerViewAdapter<String> adapter = (BindingRecyclerViewAdapter<String>) recyclerView.getAdapter();

        assertThat(adapter).isInstanceOf(TestHelpers.MyBindingRecyclerViewAdapter.class);
    }
}