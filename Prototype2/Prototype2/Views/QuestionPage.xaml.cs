using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;
using Prototype2.ViewModel;

namespace Prototype2.Views
{
    public partial class QuestionPage : PhoneApplicationPage
    {
        private QuestionPageViewModel ViewModel;
        public QuestionPage()
        {
            InitializeComponent();
            ViewModel = new QuestionPageViewModel();
            DataContext = ViewModel;
        }

        private void Answer_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/Views/AnswerPage.xaml", UriKind.RelativeOrAbsolute));
        }

        private void Hint_Click(object sender, RoutedEventArgs e)
        {
            NavigationService.Navigate(new Uri("/Views/HintPage.xaml", UriKind.RelativeOrAbsolute));
        }
    }
}