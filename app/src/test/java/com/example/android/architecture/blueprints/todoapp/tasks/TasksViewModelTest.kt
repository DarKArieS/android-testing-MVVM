package com.example.android.architecture.blueprints.todoapp.tasks

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.architecture.blueprints.todoapp.Event
import com.example.android.architecture.blueprints.todoapp.getOrAwaitValue
import org.hamcrest.CoreMatchers.not
import org.hamcrest.CoreMatchers.nullValue
import org.junit.Assert.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [28])
class TasksViewModelTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()
    
    @Test
    fun addNewTask_setsNewTaskEvent() {
        // Given a fresh ViewModel
        val tasksViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())
        
        // When adding a new task, maybe asynchronous ...
        tasksViewModel.addNewTask()
        
        // Then the new task event is triggered
        val value = tasksViewModel.newTaskEvent.getOrAwaitValue()
        
        assertThat(value.getContentIfNotHandled(), not(nullValue()))
    }
    
}
